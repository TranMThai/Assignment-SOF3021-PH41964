package com.sof_3021.ph41964.controller;

import com.sof_3021.ph41964.entity.Color;
import com.sof_3021.ph41964.entity.Image;
import com.sof_3021.ph41964.entity.Product;
import com.sof_3021.ph41964.entity.ProductDetail;
import com.sof_3021.ph41964.entity.Size;
import com.sof_3021.ph41964.model.ProductInfo;
import com.sof_3021.ph41964.service.ColorService;
import com.sof_3021.ph41964.service.ImageService;
import com.sof_3021.ph41964.service.ProductDetailService;
import com.sof_3021.ph41964.service.ProductService;
import com.sof_3021.ph41964.service.SizeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ColorService colorService;

    @Autowired
    SizeService sizeService;

    @Autowired
    ProductDetailService productDetailService;

    @Autowired
    ProductService productService;

    @Autowired
    ImageService imageService;

    @ModelAttribute("sizes")
    public List<Size> getSize() {
        return sizeService.getAllActive();
    }

    @ModelAttribute("colors")
    public List<Color> getColors() {
        return colorService.getAllActive();
    }

    @GetMapping("")
    public String index(@RequestParam(name = "page", defaultValue = "0") Integer page,
                        Model model) {
        model.addAttribute("list", productService.getByPageActive(page));
        model.addAttribute("url", "/product?");
        return "employee/product/Index";
    }

    @GetMapping("search")
    public String search(@RequestParam(name = "page", defaultValue = "0") Integer page,
                         @RequestParam("search") String search,
                         Model model) {
        model.addAttribute("list", productService.search(page,search));
        model.addAttribute("url", "/product/search?search="+search+"&");
        return "employee/product/Index";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") String id,
                         Model model) {
        model.addAttribute("product", productService.getById(Integer.valueOf(id)));
        return "employee/product/Detail";
    }

    @GetMapping("remove")
    public String remove(@RequestParam("id") String id,
                         Model model) {
        Product product = productService.getById(Integer.valueOf(id));
        product.setStatus(false);
        productService.update(product);
        return "redirect:/product";
    }

    @GetMapping("create")
    public String createView(Model model) {
        model.addAttribute("product", new Product());
        return "employee/product/Create";
    }

    @Transactional
    @PostMapping("create")
    public String create(@Valid @ModelAttribute("product") Product product,
                         BindingResult result,
                         @RequestParam("imgs") Optional<List<String>> images,
                         @RequestParam("sizes") Optional<List<Size>> opSizes,
                         @RequestParam("colors") Optional<List<Color>> opColors) {

        if (result.hasErrors() || opSizes.isEmpty() || opColors.isEmpty()) {
            return "employee/product/Create";
        }
        if (images.isPresent()) {
            List<String> listUrl = images.get();
            List<Image> imageList = new ArrayList<>();
            for (String url : listUrl) {
                if (!url.equals("")) {
                    Image newImage = new Image();
                    newImage.setUrl(url);
                    newImage.setStatus(true);
                    newImage.setProduct(product);
                    imageService.create(newImage);
                    imageList.add(newImage);
                }
            }
            product.setImages(imageList);
        }

        product.setStatus(true);
        productService.create(product);

        for (Size size : opSizes.get()) {
            for (Color color : opColors.get()) {
                ProductDetail productDetail = new ProductDetail();
                productDetail.setCode(product.getCode() + "_" + color.getCode() + "_" + size.getCode());
                productDetail.setProduct(product);
                productDetail.setQuantity(10);
                productDetail.setColor(color);
                productDetail.setSize(size);
                productDetail.setStatus(true);
                productDetailService.create(productDetail);
            }
        }

        return "redirect:/product";
    }

    @GetMapping("remove_detail")
    public String removeDetail(@RequestParam("id") String id,
                               Model model) {
        ProductDetail productDetail = productDetailService.getById(Integer.valueOf(id));
        productDetail.setStatus(false);
        productDetailService.update(productDetail);
        return "redirect:/product/detail/" + productDetail.getProduct().getId();
    }

    @PostMapping("update_detail")
    public String updateDetail(@RequestParam("id") String id,
                               @RequestParam("quantity") String quantity) {
        ProductDetail productDetail = productDetailService.getById(Integer.valueOf(id));
        productDetail.setQuantity(Integer.valueOf(quantity));
        productDetailService.update(productDetail);
        return "redirect:/product/detail/" + productDetail.getProduct().getId();
    }

    @GetMapping("update/{id}")
    public String updateView(@PathVariable("id") String id,
                             Model model) {
        ProductInfo productInfo = new ProductInfo(productService.getById(Integer.valueOf(id)));
        model.addAttribute("product", productInfo);
        return "employee/product/Update";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("product") ProductInfo productInfo) {
        Product product = productService.getById(productInfo.getId());
        product.setCode(productInfo.getCode());
        product.setName(productInfo.getName());
        product.setPrice(productInfo.getPrice());
        productService.update(product);
        return "redirect:/product";
    }

}

package com.sof_3021.ph41964.dto;

import com.sof_3021.ph41964.entity.Bill;
import com.sof_3021.ph41964.entity.BillDetail;
import com.sof_3021.ph41964.entity.Customer;
import com.sof_3021.ph41964.entity.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDTO {

    private Integer id;

    private Employee employee;

    private Customer customer;

    private Date purchaseDate;

    private Boolean status;

    private List<BillDetail> billDetails;

    public BillDTO(Bill bill) {
        this.id = bill.getId();
        this.employee = bill.getEmployee();
        this.customer = bill.getCustomer();
        this.purchaseDate = bill.getPurchaseDate();
        this.status = bill.getStatus();
        this.billDetails = bill.getBillDetails();
    }
}

package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.NoRecordsFoundException;
import com.masai.model.OrderBill;
import com.masai.model.Product;
import com.masai.service.OrderBillService;

import jakarta.persistence.criteria.Order;

@RestController
@RequestMapping("/orderbill")
public class OrderBillController {

    @Autowired
    private OrderBillService orderService;


    @PostMapping("/add")
    public ResponseEntity<OrderBill> addOrderBill(@RequestBody OrderBill orderBill) {
    	OrderBill order = orderService.addOrderBill(orderBill); 
            return new ResponseEntity<OrderBill>(order, HttpStatus.ACCEPTED);
    }

	
	   @GetMapping("/update")
	    public ResponseEntity<OrderBill> updateOrderBill(@RequestBody OrderBill orderBill) throws NoRecordsFoundException{
	        return new ResponseEntity<>(orderService.updateOrderBill(orderBill),HttpStatus.OK);

	    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OrderBill> deleteOrderBill(@PathVariable("id") Integer id) throws NoRecordsFoundException{
        return new ResponseEntity<>(orderService.cancelOrderBill(id),HttpStatus.OK);

    }


 


    @GetMapping("/bills/allbills")
    public ResponseEntity<List<OrderBill>> showAllOrders() throws NoRecordsFoundException{
        return new ResponseEntity<>(orderService.showAllOrderBill(),HttpStatus.OK);

    }

    @GetMapping("/orderbill/{billid}")
    public ResponseEntity<OrderBill> showAllOrderBill(@PathVariable("billid") Integer orderBillId) throws NoRecordsFoundException {
    	OrderBill p = orderService.showAllOrderBill(orderBillId);
		
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
    }
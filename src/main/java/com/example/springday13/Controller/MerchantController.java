package com.example.springday13.Controller;

import com.example.springday13.Model.Branch;
import com.example.springday13.Model.Merchant;
import com.example.springday13.Service.BranchService;
import com.example.springday13.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Merchant")
@RequiredArgsConstructor
public class MerchantController {
    final MerchantService merchantService;
    final BranchService branchService;
    //display
    @GetMapping("/display")
    public ResponseEntity getAllMerchant(){
        List<Merchant> merchants = merchantService.getMerchant();
        return ResponseEntity.status(200).body(merchants);
    }

    //Add
    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant){
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body("Merchant Added");
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@Valid @RequestBody Merchant merchant, @PathVariable Integer id) {
        merchantService.updateMerchant(id, merchant);
        return ResponseEntity.status(200).body("Merchant is updated ");
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable Integer id){
        merchantService.deleteMerchant(id);
        return ResponseEntity.status(200).body("Merchant is deleted ");
    }


}

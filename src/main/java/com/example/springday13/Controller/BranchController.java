package com.example.springday13.Controller;

import com.example.springday13.Model.Branch;
import com.example.springday13.Model.Merchant;
import com.example.springday13.Service.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Branch")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;
    @GetMapping("/display")
    public ResponseEntity getBranch(){
        List<Branch> branches = branchService.getBranch();
        return ResponseEntity.status(200).body(branches);
    }

    //Add
    @PostMapping("/add")
    public ResponseEntity addBranch(@Valid @RequestBody Branch branch){
        branchService.addBranch(branch);
        return ResponseEntity.status(200).body("branch Added");
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateBranch(@Valid @RequestBody Branch branch, @PathVariable Integer id) {
        branchService.updateBranch(id, branch);
        return ResponseEntity.status(200).body("branch is updated ");
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBranch(@PathVariable Integer id){
        branchService.deleteBranch(id);
        return ResponseEntity.status(200).body("Merchant is deleted ");
    }

    // assign
    @GetMapping("/assignBranch/{merchant_id}/{branch_id}")
    public ResponseEntity assignBranch(@PathVariable Integer merchant_id, @PathVariable Integer branch_id){
        branchService.assignedMerchantToBranch(merchant_id,branch_id);
        return ResponseEntity.status(200).body("Branch is assigned ");

    }
}



package com.example.springday13.Service;
import com.example.springday13.Exception.ApiException;
import com.example.springday13.Model.Branch;
import com.example.springday13.Model.Merchant;
import com.example.springday13.Repository.BranchRepository;
import com.example.springday13.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;

    private final MerchantRepository merchantRepository;
    // ADD
    public void addBranch(Branch branch){
        branchRepository.save(branch);
    }

    // Display
    public List<Branch> getBranch(){
        return  branchRepository.findAll();
    }

    // update
    public void updateBranch(Integer id, Branch branch) {
        Branch newBranch = branchRepository.findBranchById(id);
        if (newBranch == null) {
            throw new ApiException("order not found!!");
        }
        branchRepository.save(newBranch);
    }

    // delete

    public void deleteBranch(Integer id) {
        Branch branch = branchRepository.findBranchById(id);
        if (branch==null) {
            throw new ApiException("Id is not found");
        }
        branchRepository.delete(branch);
    }

    public void assignedMerchantToBranch(Integer merchant_id , Integer Branch_id){

        Merchant merchant = merchantRepository.findMerchantById(merchant_id);
        Branch branch = branchRepository.findBranchById(Branch_id);
        if (branch==null ||merchant==null ) {
            throw new ApiException("Id is not found");
        }
        branch.setMerchant(merchant);
        branchRepository.save(branch);


    }



}

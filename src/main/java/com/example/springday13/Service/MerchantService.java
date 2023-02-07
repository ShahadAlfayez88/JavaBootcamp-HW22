package com.example.springday13.Service;

import com.example.springday13.Exception.ApiException;
import com.example.springday13.Model.Branch;
import com.example.springday13.Model.Merchant;
import com.example.springday13.Repository.MerchantRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepository merchantRepository;

    // ADD
    public void addMerchant(Merchant merchant){
        merchantRepository.save(merchant);
    }

    // Display
    public List<Merchant> getMerchant(){
        return  merchantRepository.findAll();
    }

    // update
    public void updateMerchant(Integer id, Merchant merchant) {
        Merchant newMerchant = merchantRepository.findMerchantById(id);
        if (newMerchant == null) {
            throw new ApiException("Merchant not found!!");
        }
        merchantRepository.save(newMerchant);
    }

    // delete

    public void deleteMerchant(Integer id) {
        Merchant newMerchant = merchantRepository.findMerchantById(id);
        if (newMerchant==null) {
            throw new ApiException("Merchant is not found");
        }
        merchantRepository.delete(newMerchant);
    }



}


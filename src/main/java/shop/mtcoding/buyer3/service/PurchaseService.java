package shop.mtcoding.buyer3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.buyer3.dto.PurchaseAllDto;
import shop.mtcoding.buyer3.model.Product;
import shop.mtcoding.buyer3.model.ProductRepository;
import shop.mtcoding.buyer3.model.PurchaseRepository;

@Service
public class PurchaseService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Transactional
    public int 구매하기(int principalId, int productId, int count) {
        Product product = productRepository.findById(productId);
        if (product == null) {
            return -1;
        }

        if (product.getQty() < count) {
            return -1;
        }

        int result = productRepository.update(productId, product.getName(), product.getPrice(),
                product.getQty() - count);
        if (result != 1) {
            return -1;
        }

        int result2 = purchaseRepository.insert(principalId, productId, count);
        if (result2 != 1) {
            return -1;
        }

        return 1;
    }

    @Transactional
    public int 구매목록제거(int purchaseId, int principalId) {
        List<PurchaseAllDto> purchaseList = purchaseRepository.findByUserId(principalId);

        int cnt = 0;
        int count = 0;

        for (PurchaseAllDto purchaseAllDto : purchaseList) {
            if (purchaseAllDto.getId() == purchaseId) {
                count = purchaseAllDto.getCount();
                cnt = 1;
            }
        }

        if (cnt != 1) {
            return -1;
        }

        Product product = purchaseRepository.findProductById(purchaseId);
        if (product == null) {
            return -1;
        }

        int res = productRepository.update(product.getId(), product.getName(), product.getPrice(),
                product.getQty() + count);
        if (res != 1) {
            return -1;
        }

        int res2 = purchaseRepository.deleteById(purchaseId);

        if (res2 != 1) {
            return -1;
        }

        return 1;
    }
}

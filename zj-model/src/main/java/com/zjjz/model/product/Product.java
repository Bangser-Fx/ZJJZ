package com.zjjz.model.product;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-29 21:31
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends ProductBace implements Serializable {

    private List<HashMap<String,ProductMarket>> marketHashMaps;

    public Product(List<HashMap<String, ProductMarket>> marketHashMaps) {
        this.marketHashMaps = marketHashMaps;
    }
}

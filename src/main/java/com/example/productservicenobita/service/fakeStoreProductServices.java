package com.example.productservicenobita.service;


import com.example.productservicenobita.dtos.fakeStoreProductDTO;
import com.example.productservicenobita.models.Category;
import com.example.productservicenobita.models.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
@Configuration
public class fakeStoreProductServices implements ProductServices {


    private final String url = "https://fakestoreapi.com/products";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Product> getProducts() {

        List<fakeStoreProductDTO> fakeStoreProductDTOinstances = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<fakeStoreProductDTO>>() {
                }).getBody();

        assert fakeStoreProductDTOinstances != null;

        return fakeStoreProductDTOinstances.stream().map(this::mapToProduct).toList();
    }

    private Product mapToProduct(fakeStoreProductDTO fakeStoreProductDTO) {
        Category category = new Category(1L, fakeStoreProductDTO.getCategory());
        category.setName(fakeStoreProductDTO.getCategory());
        return new Product(fakeStoreProductDTO.getId(), fakeStoreProductDTO.getTitle(), fakeStoreProductDTO.getDescription(), fakeStoreProductDTO.getPrice(), category, fakeStoreProductDTO.getImage());
    }
    //Done by nobitaN0bi
    @Override
    public Product getProduct(Long id) {

        fakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject(url + "/" + id, fakeStoreProductDTO.class);

        assert fakeStoreProductDTO != null;

        return mapToProduct(fakeStoreProductDTO);
    }



    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete(url + "/" + id);
    }



    @Override
    public List<String> getCategories() {

        List<String> categories = restTemplate.exchange(
                url + "/categories",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                }).getBody();

        assert categories != null;

        return categories;
    }

    @Override
    public List<Product> getLimitedProducts(int limit) {

//https://fakestoreapi.com/products?limit=
        List<fakeStoreProductDTO> fakeStoreProductDTOinstances = restTemplate.exchange(
                url + "?limit=" + limit,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<fakeStoreProductDTO>>() {
                }).getBody();

        assert fakeStoreProductDTOinstances != null;

        return fakeStoreProductDTOinstances.stream().map(this::mapToProduct).toList();

    }

    @Override
    public List<Product> getSortedProducts(String sort) {

//https://fakestoreapi.com/products?sort=
        List<fakeStoreProductDTO> fakeStoreProductDTOinstances = restTemplate.exchange(
                url + "?sort=" + sort,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<fakeStoreProductDTO>>() {
                }).getBody();

        assert fakeStoreProductDTOinstances != null;

        return fakeStoreProductDTOinstances.stream().map(this::mapToProduct).toList();

    }
}

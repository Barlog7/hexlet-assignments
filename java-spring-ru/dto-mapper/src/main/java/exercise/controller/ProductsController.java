package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;

import exercise.repository.ProductRepository;
import exercise.dto.ProductDTO;
import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.ProductMapper;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    // BEGIN
    @Autowired
    private ProductMapper productMapper;

    @GetMapping(path = "")
    public List<ProductDTO> index() {
        var prodacts = productRepository.findAll();
        return prodacts.stream().map(v -> {return productMapper.map(v);}).toList();
    }

    @GetMapping(path = "/{id}")
    public ProductDTO show(@PathVariable long id) {
        var prodact = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Prodact with id " + id + " not found"));
        var dto = productMapper.map(prodact);
        return dto;
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@RequestBody ProductCreateDTO dto) {
        var prodact = productMapper.map(dto);
        productRepository.save(prodact);
        var dtoReturn = productMapper.map(prodact);
        return dtoReturn;
    }

    @PutMapping(path = "/{id}")
    public ProductDTO update(@PathVariable long id, @RequestBody ProductUpdateDTO dto) {
        var prodact = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Prodact with id " + id + " not found"));
        productMapper.update(dto, prodact);
        productRepository.save(prodact);
        var dtoReturn = productMapper.map(prodact);
        return dtoReturn;
    }
    // END
}

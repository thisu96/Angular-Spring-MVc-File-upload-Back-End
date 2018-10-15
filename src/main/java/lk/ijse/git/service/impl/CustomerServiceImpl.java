package lk.ijse.git.service.impl;

import lk.ijse.git.dto.CustomerDTO;
import lk.ijse.git.entity.Customer;
import lk.ijse.git.repository.CustomerRepository;
import lk.ijse.git.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    private String folderPath = "/home/thisu/Documents/project-data/git/";

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getCustomerName(),
                customerDTO.getAddress(),
                customerDTO.getContct(),
                customerDTO.getImageUrl());
        customerRepository.save(customer);
        return true;
    }

    @Override
    public int uploadFile(MultipartFile[] files) {
        int reply = 0;
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                reply = 1;
            }
            try {
                // Get the file and save it somewhere
                byte[] bytes = file.getBytes();
                Path path = Paths.get(folderPath + file.getOriginalFilename());
                Files.write(path, bytes);

                reply = 2;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return reply;
    }
}

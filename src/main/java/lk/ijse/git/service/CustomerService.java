package lk.ijse.git.service;

import lk.ijse.git.dto.CustomerDTO;
import org.springframework.web.multipart.MultipartFile;

public interface CustomerService {

    public boolean saveCustomer(CustomerDTO customerDTO);

    public int uploadFile(MultipartFile[] files);

}

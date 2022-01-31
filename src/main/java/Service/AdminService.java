package Service;

import Entity.Admin;
import Entity.User;
import Repository.AdminRepository;

import java.util.List;

public class AdminService implements Service<Admin> {
    AdminRepository adminRepository = new AdminRepository();


    @Override
    public int add(Admin admin) {
        return adminRepository.add(admin);
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public int update(Admin admin) {
        return adminRepository.update(admin);
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}

package Service;

import entity.Category;
import repository.CategoryRepository;

import java.util.List;

public class CategoryService implements Service<Category> {
    private CategoryRepository categoryRepository = new CategoryRepository();


    @Override
    public int add(Category category) {
        return categoryRepository.add(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public int update(Category category) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    public List<Category> showCategory(int number){
        return categoryRepository.showCategory(number);
    }
}

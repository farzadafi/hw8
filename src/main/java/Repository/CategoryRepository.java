package Repository;

import Entity.Category;

import java.util.List;

public class CategoryRepository implements Repository<Category> {
    @Override
    public int add(Category category) {
        return 0;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public int update(Category category) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}

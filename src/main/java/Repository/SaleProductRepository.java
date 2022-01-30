package Repository;

import Entity.SaleProduct;

import java.util.List;

public class SaleProductRepository implements Repository<SaleProduct> {
    @Override
    public int add(SaleProduct saleProduct) {
        return 0;
    }

    @Override
    public List<SaleProduct> findAll() {
        return null;
    }

    @Override
    public int update(SaleProduct saleProduct) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}

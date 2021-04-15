package data.definition;

public class EndToEndBuyProductData {
    int tabIndex;
    String categoryName;
    int productIndex;
    String quantityWanted;
    String size;

    public EndToEndBuyProductData setTabIndex(int tabIndex) {
        this.tabIndex = tabIndex;
        return this;
    }

    public EndToEndBuyProductData setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public EndToEndBuyProductData setProductIndex(int productIndex) {
        this.productIndex = productIndex;
        return this;
    }

    public EndToEndBuyProductData setQuantityWanted(String quantityWanted) {
        this.quantityWanted = quantityWanted;
        return this;
    }

    public EndToEndBuyProductData setSize(String size) {
        this.size = size;
        return this;
    }

    public int getTabIndex() {
        return tabIndex;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getProductIndex() {
        return productIndex;
    }

    public String getQuantityWanted() {
        return quantityWanted;
    }

    public String getSize() {
        return size;
    }
}


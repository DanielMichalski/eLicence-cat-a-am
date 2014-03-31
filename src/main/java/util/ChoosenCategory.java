package util;

/**
 * Author: Daniel
 */
public class ChoosenCategory {
    private model.ChoosenCategory choosenCategory = model.ChoosenCategory.A;

    private static ChoosenCategory ourInstance = new ChoosenCategory();

    public static ChoosenCategory getInstance() {
        return ourInstance;
    }

    private ChoosenCategory() {
    }

    public void setChoosenCategory(model.ChoosenCategory choosenCategory) {
        this.choosenCategory = choosenCategory;
    }

    public model.ChoosenCategory getChoosenCategory() {
        return choosenCategory;
    }
}

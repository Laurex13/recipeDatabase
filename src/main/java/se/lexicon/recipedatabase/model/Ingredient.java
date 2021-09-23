package se.lexicon.recipedatabase.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredientId;

    private String ingredientName;

    @ManyToOne (cascade = {CascadeType.DETACH,CascadeType.REFRESH, },
    fetch = FetchType.EAGER)
    private RecipeIngredient recipeIngredient;

    protected Ingredient(){

    }

    public Ingredient( int ingredientId, String ingredientName, RecipeIngredient recipeIngredient) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.recipeIngredient = recipeIngredient;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public RecipeIngredient getRecipeIngredient() {
        return recipeIngredient;
    }

    public void setRecipeIngredient(RecipeIngredient recipeIngredient) {
        this.recipeIngredient = recipeIngredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return getIngredientId() == that.getIngredientId() && getIngredientName().equals(that.getIngredientName()) && getRecipeIngredient().equals(that.getRecipeIngredient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIngredientId(), getIngredientName(), getRecipeIngredient());
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientId=" + ingredientId +
                ", ingredientName='" + ingredientName + '\'' +
                ", recipeIngredient=" + recipeIngredient +
                '}';
    }
}

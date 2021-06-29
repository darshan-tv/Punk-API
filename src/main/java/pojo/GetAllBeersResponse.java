package pojo;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetAllBeersResponse {
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    static int statusCode;

    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("tagline")
    public String getTagline() {
        return this.tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    String tagline;

    @JsonProperty("first_brewed")
    public String getFirst_brewed() {
        return this.first_brewed;
    }

    public void setFirst_brewed(String first_brewed) {
        this.first_brewed = first_brewed;
    }

    String first_brewed;

    @JsonProperty("description")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String description;

    @JsonProperty("image_url")
    public String getImage_url() {
        return this.image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    String image_url;

    @JsonProperty("abv")
    public double getAbv() {
        return this.abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    double abv;

    @JsonProperty("ibu")
    public double getIbu() {
        return this.ibu;
    }

    public void setIbu(double ibu) {
        this.ibu = ibu;
    }

    double ibu;

    @JsonProperty("target_fg")
    public int getTarget_fg() {
        return this.target_fg;
    }

    public void setTarget_fg(int target_fg) {
        this.target_fg = target_fg;
    }

    int target_fg;

    @JsonProperty("target_og")
    public double getTarget_og() {
        return this.target_og;
    }

    public void setTarget_og(double target_og) {
        this.target_og = target_og;
    }

    double target_og;

    @JsonProperty("ebc")
    public int getEbc() {
        return this.ebc;
    }

    public void setEbc(int ebc) {
        this.ebc = ebc;
    }

    int ebc;

    @JsonProperty("srm")
    public double getSrm() {
        return this.srm;
    }

    public void setSrm(double srm) {
        this.srm = srm;
    }

    double srm;

    @JsonProperty("ph")
    public double getPh() {
        return this.ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    double ph;

    @JsonProperty("attenuation_level")
    public double getAttenuation_level() {
        return this.attenuation_level;
    }

    public void setAttenuation_level(double attenuation_level) {
        this.attenuation_level = attenuation_level;
    }

    double attenuation_level;

    @JsonProperty("volume")
    public Volume getVolume() {
        return this.volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    Volume volume;

    @JsonProperty("boil_volume")
    public BoilVolume getBoil_volume() {
        return this.boil_volume;
    }

    public void setBoil_volume(BoilVolume boil_volume) {
        this.boil_volume = boil_volume;
    }

    BoilVolume boil_volume;

    @JsonProperty("method")
    public Method getMethod() {
        return this.method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    Method method;

    @JsonProperty("ingredients")
    public Ingredients getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    Ingredients ingredients;

    @JsonProperty("food_pairing")
    public List<String> getFood_pairing() {
        return this.food_pairing;
    }

    public void setFood_pairing(List<String> food_pairing) {
        this.food_pairing = food_pairing;
    }

    List<String> food_pairing;

    @JsonProperty("brewers_tips")
    public String getBrewers_tips() {
        return this.brewers_tips;
    }

    public void setBrewers_tips(String brewers_tips) {
        this.brewers_tips = brewers_tips;
    }

    String brewers_tips;

    @JsonProperty("contributed_by")
    public String getContributed_by() {
        return this.contributed_by;
    }

    public void setContributed_by(String contributed_by) {
        this.contributed_by = contributed_by;
    }

    String contributed_by;

public static class Volume {
    @JsonProperty("value")
    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    int value;

    @JsonProperty("unit")
    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    String unit;
}

public static class BoilVolume {
    @JsonProperty("value")
    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    int value;

    @JsonProperty("unit")
    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    String unit;
}

public static class Temp {
    @JsonProperty("value")
    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    int value;

    @JsonProperty("unit")
    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    String unit;
}

public static class MashTemp {
    @JsonProperty("temp")
    public Temp getTemp() {
        return this.temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    Temp temp;

    @JsonProperty("duration")
    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    int duration;
}

public static class Fermentation {
    @JsonProperty("temp")
    public Temp getTemp() {
        return this.temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    Temp temp;
}

public static class Method {
    @JsonProperty("mash_temp")
    public List<MashTemp> getMash_temp() {
        return this.mash_temp;
    }

    public void setMash_temp(List<MashTemp> mash_temp) {
        this.mash_temp = mash_temp;
    }

    List<MashTemp> mash_temp;

    @JsonProperty("fermentation")
    public Fermentation getFermentation() {
        return this.fermentation;
    }

    public void setFermentation(Fermentation fermentation) {
        this.fermentation = fermentation;
    }

    Fermentation fermentation;

    @JsonProperty("twist")
    public String getTwist() {
        return this.twist;
    }

    public void setTwist(String twist) {
        this.twist = twist;
    }

    String twist;
}

public static class Amount {
    @JsonProperty("value")
    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    double value;

    @JsonProperty("unit")
    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    String unit;
}

public static class Malt {
    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("amount")
    public Amount getAmount() {
        return this.amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    Amount amount;
}

public static class Hop {
    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("amount")
    public Amount getAmount() {
        return this.amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    Amount amount;

    @JsonProperty("add")
    public String getAdd() {
        return this.add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    String add;

    @JsonProperty("attribute")
    public String getAttribute() {
        return this.attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    String attribute;
}

public static class Ingredients {
    @JsonProperty("malt")
    public List<Malt> getMalt() {
        return this.malt;
    }

    public void setMalt(List<Malt> malt) {
        this.malt = malt;
    }

    List<Malt> malt;

    @JsonProperty("hops")
    public List<Hop> getHops() {
        return this.hops;
    }

    public void setHops(List<Hop> hops) {
        this.hops = hops;
    }

    List<Hop> hops;

    @JsonProperty("yeast")
    public String getYeast() {
        return this.yeast;
    }

    public void setYeast(String yeast) {
        this.yeast = yeast;
    }

    String yeast;
}

}


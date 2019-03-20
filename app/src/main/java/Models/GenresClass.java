
package Models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenresClass {

    @SerializedName("genres")
    @Expose
    private List<Genre> genres = null;



    private Map<Integer, String> generMap = new HashMap<Integer, String>();


    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Map<Integer, String> getMap() {

        if(genres==null)
            return null;
        for (int i =0; i<genres.size();i++)
        {
            int key = genres.get(i).getId();
            String value = genres.get(i).getName();
            generMap.put(key,value);
        }
        return generMap;
    }


}

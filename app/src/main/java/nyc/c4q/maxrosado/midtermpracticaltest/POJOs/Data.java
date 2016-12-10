package nyc.c4q.maxrosado.midtermpracticaltest.POJOs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by maxrosado on 12/10/16.
 */

public class Data {
    private Integer count;
    private Integer size;
    @SerializedName("records")
    private List<MainPOJO> records = null;
    private String anchorStr;

    public Integer getSize() {
        return size;
    }

    public Integer getCount() {
        return count;
    }

    public List<MainPOJO> getRecords() {
        return records;
    }

    public String getAnchorStr() {
        return anchorStr;
    }
}

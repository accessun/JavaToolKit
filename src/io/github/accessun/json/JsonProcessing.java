package io.github.accessun.json;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class JsonProcessing {
    static final String portalJson = "{\"name\":\"root\",\"displayName\":\"root\",\"description\":\"\",\"guiType\":\"\",\"isHidden\":false,\"guiContainers\":[{\"name\":\"default\",\"displayName\":\"public database\",\"description\":\"default\",\"guiType\":\"martanalysis\",\"isHidden\":false,\"guiContainers\":[],\"marts\":[{\"name\":\"DIM_SAMPLE_config\",\"displayName\":\"DIM_SAMPLE_config\",\"description\":\"DIM_SAMPLE_config\",\"config\":\"DIM_SAMPLE_config\",\"isHidden\":false,\"operation\":\"SINGLESELECT\",\"meta\":\"\",\"group\":\"public_data_a\"},{\"name\":\"karyotype_start_config\",\"displayName\":\"karyotype_start_config\",\"description\":\"karyotype_start_config\",\"config\":\"karyotype_start_config\",\"isHidden\":false,\"operation\":\"SINGLESELECT\",\"meta\":\"\",\"group\":\"public_data_a\"},{\"name\":\"qtl_feature_config\",\"displayName\":\"qtl_feature_config\",\"description\":\"qtl_feature_config\",\"config\":\"qtl_feature_config\",\"isHidden\":false,\"operation\":\"SINGLESELECT\",\"meta\":\"\",\"group\":\"\"},{\"name\":\"marker_end_1_config\",\"displayName\":\"marker_end_1_config\",\"description\":\"marker_end_1_config\",\"config\":\"marker_end_1_config\",\"isHidden\":false,\"operation\":\"SINGLESELECT\",\"meta\":\"\",\"group\":\"\"},{\"name\":\"karyotype_start_1_config\",\"displayName\":\"karyotype_start_1_config\",\"description\":\"karyotype_start_1_config\",\"config\":\"karyotype_start_1_config\",\"isHidden\":false,\"operation\":\"SINGLESELECT\",\"meta\":\"\",\"group\":\"\"},{\"name\":\"karyotype_end_config\",\"displayName\":\"karyotype_end_config\",\"description\":\"karyotype_end_config\",\"config\":\"karyotype_end_config\",\"isHidden\":false,\"operation\":\"SINGLESELECT\",\"meta\":\"\",\"group\":\"\"},{\"name\":\"marker_start_1_config\",\"displayName\":\"marker_start_1_config\",\"description\":\"marker_start_1_config\",\"config\":\"marker_start_1_config\",\"isHidden\":false,\"operation\":\"SINGLESELECT\",\"meta\":\"\",\"group\":\"\"},{\"name\":\"marker_start_2_config\",\"displayName\":\"marker_start_2_config\",\"description\":\"marker_start_2_config\",\"config\":\"marker_start_2_config\",\"isHidden\":false,\"operation\":\"SINGLESELECT\",\"meta\":\"\",\"group\":\"\"},{\"name\":\"marker_end_2_config\",\"displayName\":\"marker_end_2_config\",\"description\":\"marker_end_2_config\",\"config\":\"marker_end_2_config\",\"isHidden\":false,\"operation\":\"SINGLESELECT\",\"meta\":\"\",\"group\":\"\"}]},{\"name\":\"report\",\"displayName\":\"report\",\"description\":\"report\",\"guiType\":\"martreport\",\"isHidden\":false,\"guiContainers\":[],\"marts\":[]},{\"name\":\"myhealthgeneDataSets\",\"displayName\":\"myhealthgeneDataSets\",\"description\":\"myhealthgeneDataSets\",\"guiType\":\"martanalysis\",\"isHidden\":false,\"guiContainers\":[],\"marts\":[{\"name\":\"karyotype_end_config_1\",\"displayName\":\"karyotype_end_config_1\",\"description\":\"karyotype_end_config_1\",\"config\":\"karyotype_end_config_1\",\"isHidden\":false,\"operation\":\"SINGLESELECT\",\"meta\":\"\",\"group\":\"\"},{\"name\":\"marker_start_1_config_1\",\"displayName\":\"marker_start_1_config_1\",\"description\":\"marker_start_1_config_1\",\"config\":\"marker_start_1_config_1\",\"isHidden\":false,\"operation\":\"SINGLESELECT\",\"meta\":\"\",\"group\":\"\"},{\"name\":\"marker_end_2_config_1\",\"displayName\":\"marker_end_2_config_1\",\"description\":\"marker_end_2_config_1\",\"config\":\"marker_end_2_config_1\",\"isHidden\":false,\"operation\":\"SINGLESELECT\",\"meta\":\"\",\"group\":\"\"},{\"name\":\"DIM_SAMPLE_config_1\",\"displayName\":\"DIM_SAMPLE_config_1\",\"description\":\"DIM_SAMPLE_config_1\",\"config\":\"DIM_SAMPLE_config_1\",\"isHidden\":false,\"operation\":\"SINGLESELECT\",\"meta\":\"\",\"group\":\"\"}]}],\"marts\":[]}";

    @Test
    public void test() {
        Gson gson = new GsonBuilder().create();
        JsonElement element = gson.toJsonTree(portalJson);

    }
}

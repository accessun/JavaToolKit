package io.github.accessun.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.TypeFactory;

import io.github.accessun.bean.Department;
import io.github.accessun.bean.Person;

public class TestJackson {

    @Test
    public void testObjectToJson() throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, String> personalInfo = new HashMap<>();
        personalInfo.put("email", "david@example.com");
        personalInfo.put("hobby", "jogging");
        Person manager = new Person(1001, "David", 32, personalInfo);

        Department department = new Department(201, "IT", manager);
        // mapper.setSerializationInclusion(Include.NON_EMPTY);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        mapper.writeValue(new File("files/jackson_data.json"), department);
        department.setDeptName("Accounting");
        mapper.writeValue(new File("files/jackson_data.json"), department);
    }
    
    @Test
    public void testJsonToObject() throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Department department = mapper.readValue(new File("files/jsonToObject.json"), Department.class);
        System.out.println(department);
    }
    
    
    @Test
    public void testMultipleJsonToObject() throws JsonParseException, JsonProcessingException, IOException {

        final InputStream in = new FileInputStream("files/multipleJsonToObject.json");
        
        for (Iterator it = new ObjectMapper().readValues(new JsonFactory().createJsonParser(in), Department.class); it
                .hasNext();)
            System.out.println(it.next());
        
        in.close();
    }
    
    @Test
    public void testMultipleJsonToObjectList() throws JsonParseException, JsonMappingException, IOException {
        List<Department> departments = null;
        
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory typeFactory = mapper.getTypeFactory();
        
        departments = mapper.readValue(new File("files/multipleJsonToObjectMap.json"), typeFactory.constructCollectionType(List.class, Department.class));
        
        System.out.println(departments);
        
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.writeValue(new File("files/multipleJsonToObjectMap_1.json"), departments);
    }
    

    @SuppressWarnings("deprecation")
    @Test
    public void testTreeModel() throws IOException {

        // Create the node factory that gives us nodes.
        JsonNodeFactory jsonNodeFactory = new JsonNodeFactory(false);

        // create a json factory to write the treenode as json. for example
        // we just write to console
        JsonFactory jsonFactory = new JsonFactory();
        JsonGenerator jsonGenerator = jsonFactory.createGenerator(System.out);
        ObjectMapper mapper = new ObjectMapper();

        // the root node - department
        // JsonNode department = jsonNodeFactory.objectNode();
        ObjectNode department = jsonNodeFactory.objectNode();
        ObjectNode manager = jsonNodeFactory.objectNode();

        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        department.put("id", 202);
        department.put("deptName", "IT");
        mapper.writeTree(jsonGenerator, department);

        manager.put("id", 1001);
        manager.put("name", "Mark");
        mapper.writeTree(jsonGenerator, manager);

        department.put("manager", manager);
        mapper.writeTree(jsonGenerator, department);
    }

    @Test
    public void testStreamParser() throws JsonParseException, MalformedURLException, IOException {

        // get an instance of the json parser from the json factory
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(new File("files/albumjson.json"));

        // continue parsing the token till the end of input is reached
        while (!parser.isClosed()) {
            // get the token
            JsonToken token = parser.nextToken();
            // if its the last token then we are done
            if (token == null)
                break;
            // we want to look for a field that says dataset

            if (JsonToken.FIELD_NAME.equals(token) && "dataset".equals(parser.getCurrentName())) {
                // we are entering the datasets now. The first token should be
                // start of array
                token = parser.nextToken();
                if (!JsonToken.START_ARRAY.equals(token)) {
                    // bail out
                    break;
                }
                // each element of the array is an album so the next token
                // should be {
                token = parser.nextToken();
                if (!JsonToken.START_OBJECT.equals(token)) {
                    break;
                }
                // we are now looking for a field that says "album_title". We
                // continue looking till we find all such fields. This is
                // probably not a best way to parse this json, but this will
                // suffice for this example.
                while (true) {
                    token = parser.nextToken();
                    if (token == null)
                        break;
                    if (JsonToken.FIELD_NAME.equals(token) && "album_title".equals(parser.getCurrentName())) {
                        token = parser.nextToken();
                        System.out.println(parser.getText());
                    }

                }

            }

        }
    }

    @Test
    public void testStreamGenerator() throws IOException {
        JsonFactory factory = new JsonFactory();
        JsonGenerator generator = factory.createGenerator(new FileWriter(new File("files/albums.json")));

        // start writing with {
        generator.writeStartObject();
        generator.writeFieldName("title");
        generator.writeString("Free Music Archive - Albums");
        generator.writeFieldName("dataset");
        // start an array
        generator.writeStartArray();
        generator.writeStartObject();
        generator.writeStringField("album_title", "A.B.A.Y.A.M");
        generator.writeEndObject();
        generator.writeEndArray();
        generator.writeEndObject();

        generator.close();
    }
}

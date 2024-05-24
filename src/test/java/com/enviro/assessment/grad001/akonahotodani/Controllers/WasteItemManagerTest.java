package com.enviro.assessment.grad001.akonahotodani.Controllers;

import com.enviro.assessment.grad001.akonahotodani.Repositories.WasteItemRepository;
import com.enviro.assessment.grad001.akonahotodani.Services.WasteItemService;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class WasteItemManagerTest {

    @MockBean
    private WasteItemRepository wasteItemRepository;

    @Autowired
    WasteItemManager wasteItemManager;

    @MockBean
    private WasteItemService wasteItemService;

    @Autowired
    private MockMvc mockMvc;

    //...

    @Test
    public void validPostRequestToWasteItem_thenCorrectResponse() throws Exception {
//        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
        String user = "{\"name\": \"Can\", \"material\" : \"Plastic\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/addItem")
                        .content(user)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(new MediaType(MediaType.APPLICATION_JSON_UTF8,Charset.forName("UTF-8"))));
    }

    @Test
    public void InvalidPostRequestToWasteItem_thenCorrectResponse() throws Exception {
        String user = "{\"name\": \"\", \"material\" : \"Organic\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/addItem")
                        .content(user)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8));
    }
}

//package com.enviro.assessment.grad001.akonahotodani.Controllers;
//
//        import com.enviro.assessment.grad001.akonahotodani.Repositories.WasteItemRepository;
//        import com.enviro.assessment.grad001.akonahotodani.Services.WasteItemService;
//        import org.hamcrest.core.Is;
//        import org.junit.Test;
//        import org.junit.runner.RunWith;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//        import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//        import org.springframework.boot.test.mock.mockito.MockBean;
//        import org.springframework.http.MediaType;
//        import org.springframework.test.context.junit4.SpringRunner;
//        import org.springframework.test.web.servlet.MockMvc;
//        import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//        import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//        import java.nio.charset.Charset;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//@AutoConfigureMockMvc
//public class WasteItemManagerTest {
//
//    @MockBean
//    private WasteItemRepository wasteItemRepository;
//
//    @Autowired
//    WasteItemManager wasteItemManager;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    //...
//
//    @Test
//    public void whenPostRequestToUsersAndValidUser_thenCorrectResponse() throws Exception {
//        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
//        String user = "{\"name\": \"Can\", \"material\" : \"Plastic\"}";
//        mockMvc.perform(MockMvcRequestBuilders.post("/addItem")
//                        .content(user)
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(textPlainUtf8));
//    }
//
//    @Test
//    public void whenPostRequestToUsersAndInValidUser_thenCorrectResponse() throws Exception {
//        String user = "{\"name\": \"\", \"material\" : \"Organic\"}";
//        mockMvc.perform(MockMvcRequestBuilders.post("/addItem")
//                        .content(user)
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.status().isBadRequest())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is("Name is mandatory")))
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8));
//    }
//}


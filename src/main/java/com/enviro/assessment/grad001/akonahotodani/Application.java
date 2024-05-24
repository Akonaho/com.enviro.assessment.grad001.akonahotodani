package com.enviro.assessment.grad001.akonahotodani;

import com.enviro.assessment.grad001.akonahotodani.Entities.DisposalGuideline;
import com.enviro.assessment.grad001.akonahotodani.Entities.RecyclingTip;
import com.enviro.assessment.grad001.akonahotodani.Entities.WasteCategory;
import com.enviro.assessment.grad001.akonahotodani.Entities.WasteItem;
import com.enviro.assessment.grad001.akonahotodani.Repositories.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.akonahotodani.Repositories.RecyclingTipRepository;
import com.enviro.assessment.grad001.akonahotodani.Repositories.WasteCategoryRepository;
import com.enviro.assessment.grad001.akonahotodani.Repositories.WasteItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public CommandLineRunner run(WasteCategoryRepository wasteCategoryRepository,
//								 RecyclingTipRepository recyclingTipRepository,
//								 DisposalGuidelineRepository disposalGuidelineRepository
//								 ) throws Exception {
//		return (String[] args) -> {
//			WasteCategory cat1 = new WasteCategory();
//			cat1.setName("Recyclable");
//			cat1.setDescription("Materials that can be recycled");
//
//			WasteCategory cat2 = new WasteCategory();
//			cat2.setName("Biodegradable");
//			cat2.setDescription("Materials that are organic");
//
//			wasteCategoryRepository.save(cat1);
//			wasteCategoryRepository.save(cat2);
//
//			DisposalGuideline g1 = new DisposalGuideline();
//			g1.setMaterial("metal");
//			g1.setCategory("Recyclable");
//			g1.setGuideline("Throw it in a blue recycling bin.\n Sell to Scrap metal collectors.");
////
//
//			DisposalGuideline g2 = new DisposalGuideline();
//			g2.setMaterial("organic");
//			g2.setCategory("Biodegradable");
//			g2.setGuideline("You can use it as compost");
////
//
//			DisposalGuideline g3 = new DisposalGuideline();
//			g3.setMaterial("organic");
//			g3.setCategory("Biodegradable");
//			g3.setGuideline("You can use it to water your plants");
////
//			disposalGuidelineRepository.save(g1);
//			disposalGuidelineRepository.save(g2);
//			disposalGuidelineRepository.save(g3);
//
//
//			RecyclingTip t1 = new RecyclingTip();
//			t1.setMaterial("metal");
//			t1.setTip("Great for DIY projects");
////			t1.setItem(item1);
//
//			RecyclingTip t2 = new RecyclingTip();
//			t2.setMaterial("plastic");
//			t2.setTip("School projects");
////			t2.setItem(item2);
//
//			RecyclingTip t3 = new RecyclingTip();
//			t3.setMaterial("organic");
//			t3.setTip("Your garden will thank you later");
////			t3.setItem(item3);
//			recyclingTipRepository.save(t1);
//			recyclingTipRepository.save(t2);
//			recyclingTipRepository.save(t3);
//
//		};
//	}

}

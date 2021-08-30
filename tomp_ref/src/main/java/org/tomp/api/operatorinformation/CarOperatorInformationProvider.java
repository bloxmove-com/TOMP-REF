package org.tomp.api.operatorinformation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.providers.assets.AssetProvider;
import org.tomp.api.utils.ExternalFileService;
import org.tomp.api.utils.ObjectFromFileProvider;

import io.swagger.model.AssetType;
import io.swagger.model.Day;
import io.swagger.model.EndpointImplementation;
import io.swagger.model.Fare;
import io.swagger.model.FarePart;
import io.swagger.model.FarePart.TypeEnum;
import io.swagger.model.FarePart.UnitTypeEnum;
import io.swagger.model.StationInformation;
import io.swagger.model.SystemCalendar;
import io.swagger.model.SystemHours;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemPricingPlan;
import io.swagger.model.SystemRegion;

@Component
@ConditionalOnProperty(value = "tomp.providers.operatorinformation", havingValue = "car", matchIfMissing = false)
public class CarOperatorInformationProvider implements OperatorInformationProvider {

	@Autowired
	ExternalConfiguration configuration;

	@Autowired
	AssetProvider assetProvider;
	
	@Autowired
	ExternalFileService fileService;

	@Override
	public List<AssetType> getAvailableAssetTypes(String acceptLanguage) {
		return assetProvider.getAssetTypes();
	}

	@Override
	public SystemInformation getOperatorInformation(String acceptLanguage) {
		SystemInformation info = new SystemInformation();
		info.setSystemId("maas-car-3342");
		info.setEmail("email@caroperator.org");
		info.setLanguage(Arrays.asList(acceptLanguage));
		info.setName("Car Operator");
		info.setConditions("Terms and conditions of car transport operator...");
		return info;
	}

	@Override
	public List<StationInformation> getStations(String acceptLanguage) {
		return new ArrayList<>();
	}

	@Override
	public List<SystemRegion> getRegions(String acceptLanguage) {
		ObjectFromFileProvider<SystemRegion[]> provider = new ObjectFromFileProvider<>();
		SystemRegion[] regionArray = provider.getObject(acceptLanguage, SystemRegion[].class,
				configuration.getRegionsFile());
		List<SystemRegion> regions = new ArrayList<>();
		for (int i = 0; i < regionArray.length; i++) {
			regions.add(regionArray[i]);
		}
		return regions;
	}

	@Override
	public List<SystemPricingPlan> getPricingPlans(String acceptLanguage) {
		SystemPricingPlan carPricingPlanKm = new SystemPricingPlan();
		carPricingPlanKm.setPlanId("pricing_plan_km");
		carPricingPlanKm.setDescription("Pricing plan for kilometers");
		carPricingPlanKm.setIsTaxable(true);
		carPricingPlanKm.setName("Pricing Plan KM");
		Fare fare = new Fare();
		FarePart partsItem = new FarePart();
		partsItem.setAmount(BigDecimal.valueOf(0.70));
		partsItem.setCurrencyCode("EUR");
		partsItem.setUnitType(UnitTypeEnum.KM);
		partsItem.setType(TypeEnum.FLEX);
		fare.addPartsItem(partsItem);
		carPricingPlanKm.setFare(fare);

		SystemPricingPlan carPricingPlanMin = new SystemPricingPlan();
		carPricingPlanMin.setPlanId("pricing_plan_min");
		carPricingPlanMin.setDescription("Pricing plan for minutes");
		carPricingPlanMin.setIsTaxable(true);
		carPricingPlanMin.setName("Pricing Plan Min");
		Fare fare2 = new Fare();
		FarePart partsItem2 = new FarePart();
		partsItem2.setAmount(BigDecimal.valueOf(0.50));
		partsItem2.setCurrencyCode("EUR");
		partsItem2.setUnitType(UnitTypeEnum.MINUTE);
		partsItem2.setType(TypeEnum.FLEX);
		fare2.addPartsItem(partsItem2);
		carPricingPlanMin.setFare(fare2);

		return Arrays.asList(carPricingPlanKm,carPricingPlanMin);
	}

	@Override
	public List<SystemHours> getHours(String acceptLanguage) {
		SystemHours weekHours = new SystemHours();
		weekHours.setDays(Arrays.asList(Day.MON, Day.TUE, Day.WED, Day.THU, Day.FRI));
		weekHours.setStartTime("08:00");
		weekHours.setEndTime("18:00");

		SystemHours hours = new SystemHours();
		hours.setDays(Arrays.asList(Day.SAT));
		hours.setStartTime("10:00");
		hours.setEndTime("16:00");

		return Arrays.asList(weekHours, hours);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<SystemCalendar> getCalendar(String acceptLanguage) {
		SystemCalendar c = new SystemCalendar();
		c.setStartYear(2019);
		c.setStartMonth(1);
		c.setStartDay(1);

		c.setEndYear(new Date().getYear());
		c.setEndMonth(12);
		c.setEndDay(31);
		return new ArrayList<>();
	}

	@Override
	public List<EndpointImplementation> getMeta(String acceptLanguage) {
		return fileService.getEndPoints();
	}
}

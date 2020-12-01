package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8FeatureExamples {

	public static void main(String[] args) {

		List<FeaturePojo> list = (List<FeaturePojo>) setValues();

		// group by value and keep in map
		Map<String, List<FeaturePojo>> groupByValue = list.stream()
				.collect(Collectors.groupingBy(FeaturePojo::getValue));

		// display value from map
		System.out.println(groupByValue.get("Value1").get(0).getValue());

		// lambda function with for each
		list.forEach(action -> {
			if (action.getId() == 1) {
				action.setValue("Value1UpdatedFromForEach");
			}
		});

		// lambda iteration and display
		list.forEach(action -> System.out.println(action.getValue()));

		// steam with filter
		list.stream().filter(predicate -> predicate.getId() == 1)
				.forEach(action -> action.setValue("Value1UpdatedFromFilter"));

		// lambda iteration and display new values
		list.forEach(action -> System.out.println(action.getValue()));

		// reset value with some default value.
		list.stream().forEach(action -> action.setValue("AllValuesAreSame"));
		
		// lambda iteration and display new values
		list.forEach(action -> System.out.println(action.getValue()));

	}

	private static List<FeaturePojo> setValues() {
		List<FeaturePojo> returnList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			FeaturePojo pojo = new FeaturePojo();
			pojo.setId(i);
			pojo.setValue("Value" + i);
			returnList.add(pojo);
		}
		return returnList;
	}
}

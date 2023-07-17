package LeetCode.TwoSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataConverter {
    public static void main(String[] args) {
        List<Map<String, Object>> inputData = getData(); // 获取输入数据

        List<Map<String, Object>> outputData = convertData(inputData); // 转换数据

        System.out.println(outputData); // 打印输出数据
    }

    private static List<Map<String, Object>> convertData(List<Map<String, Object>> inputData) {
        Map<String, Map<String, List<String>>> resultMap = new HashMap<>();

        for (Map<String, Object> item : inputData) {
            String state = (String) item.get("state");
            String groupName = (String) item.get("group_name");
            String member = (String) item.get("member");

            resultMap.computeIfAbsent(state, k -> new HashMap<>())
                    .computeIfAbsent(groupName, k -> new ArrayList<>())
                    .add(member);
        }

        List<Map<String, Object>> outputData = new ArrayList<>();

        for (Map.Entry<String, Map<String, List<String>>> stateEntry : resultMap.entrySet()) {
            String state = stateEntry.getKey();
            Map<String, List<String>> stateMap = stateEntry.getValue();

            Map<String, Object> stateObj = new HashMap<>();
            stateObj.put("value", state);
            stateObj.put("label", state);

            List<Map<String, Object>> groupList = new ArrayList<>();

            for (Map.Entry<String, List<String>> groupEntry : stateMap.entrySet()) {
                String groupName = groupEntry.getKey();
                List<String> memberList = groupEntry.getValue();

                List<Map<String, Object>> memberObjList = new ArrayList<>();
                for (String member : memberList) {
                    Map<String, Object> memberObj = new HashMap<>();
                    memberObj.put("value", member);
                    memberObj.put("label", member);
                    memberObjList.add(memberObj);
                }

                Map<String, Object> groupObj = new HashMap<>();
                groupObj.put("value", groupName);
                groupObj.put("label", groupName);
                groupObj.put("children", memberObjList);

                groupList.add(groupObj);
            }

            stateObj.put("children", groupList);
            outputData.add(stateObj);
        }

        return outputData;
    }

    private static List<Map<String, Object>> getData() {
        List<Map<String, Object>> inputData = new ArrayList<>();

        Map<String, Object> data1 = new HashMap<>();
        data1.put("state", "ws");
        data1.put("group_name", "A");
        data1.put("member", "王伟");
        inputData.add(data1);

        Map<String, Object> data2 = new HashMap<>();
        data2.put("state", "ws");
        data2.put("group_name", "A");
        data2.put("member", "王二");
        inputData.add(data2);

        // 添加更多的数据...

        return inputData;
    }
}

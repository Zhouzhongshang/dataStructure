package singlelinkedlist03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: DATASTURE
 * @description: 做一个模拟省市区的demo
 * @author: zzs
 * @create: 2020-02-26 20:52
 **/
public class ProvinceCityCountryDemo {
    public static void main(String[] args) {
        List<Place> places = initData();
        List<PlaceVO> prePlaceVOList=preData(places);

        List<PlaceVO> firstCollect = prePlaceVOList.stream().filter(i -> i.getParentId().equals("0")).collect(Collectors.toList());

        List<PlaceVO> finalPlaceVoList=convert(prePlaceVOList,firstCollect);
    }

    private static List<PlaceVO> convert(List<PlaceVO> prePlaceVOList,List<PlaceVO> firstCollect) {
        /**
         * @Description: 最后的结构化数据
         * @Param: [prePlaceVOList]
         * @return: java.util.List<singlelinkedlist03.PlaceVO>
         * @Author: zzs
         * @Date: 2020/2/26
         * @Implementation: 
         *   1，先拿到最外层的数据，省份数据，parentId=0
         *   2, 遍历1的数据，同时找所有的数据，满足 1.id=all.parentId
         */
        if (firstCollect==null){
            return null;
        }

       /* firstCollect.forEach(a->{
            //满足条件的第二部分数据
            List<PlaceVO> secondCollect = prePlaceVOList.stream().filter(b -> a.getId().equals(b.getParentId())).collect(Collectors.toList());
            //找到数据立马设置
            a.setChildren(secondCollect);
            //然后继续下面找
            convert(prePlaceVOList,secondCollect);

        });*/

        for (PlaceVO i:firstCollect){
            //声名一个次级元素的list,每遍历一次声明一个
            List<PlaceVO> secondPlace=new ArrayList<>();
            for (PlaceVO k:prePlaceVOList){
                if (i.getId().equals(k.getParentId())){
                    secondPlace.add(k);
                }
            }
            //添加完成第二部分数据之后将第二部分数据，传到上面去，找第三部分数据
            i.setChildren(secondPlace);
            //然后对第二部分数据处理，无论怎么处理第一部分数据的格式都不会变了，变的只是下面的属性
            convert(prePlaceVOList,secondPlace);
        }

        return firstCollect;

    }

    private static List<PlaceVO> preData(List<Place> places) {
        /**
         * @Description: 预处理数据
         * @Param: [places]
         * @return: java.util.List<singlelinkedlist03.PlaceVO>
         * @Author: zzs
         * @Date: 2020/2/26
         * @Implementation: 
         *
         */
        List<PlaceVO> placeVOList=new ArrayList<>();
        places.forEach(a->{
            PlaceVO placeVO = new PlaceVO(a);
            placeVOList.add(placeVO);
        });
        return placeVOList;
    }

    private static List<Place> initData() {
        /**
         * @Description: 初始化最初数据也可代表从表查出的数据
         * @Param: []
         * @return: java.util.List<singlelinkedlist03.Place>
         * @Author: zzs
         * @Date: 2020/2/26
         * @Implementation:
         *
         */
        List<Place> initData = new ArrayList<>();
        initData.add(new Place("1","x","0"));
        initData.add(new Place("2","x","0"));
        initData.add(new Place("3","x","1"));
        initData.add(new Place("4","x","1"));
        initData.add(new Place("5","x","2"));
        initData.add(new Place("6","x","2"));
        initData.add(new Place("7","x","3"));
        initData.add(new Place("8","x","3"));
        initData.add(new Place("9","x","4"));
        initData.add(new Place("10","x","4"));
        initData.add(new Place("11","x","5"));

return initData;
    }
}
class PlaceVO{
    /**
     * 数据马
     */
    private String id;
    /**
     * 名字
     */
    private String dataName;
    /**
     * 父元素的码
     */
    private String parentId;
    /**
     * 子元素
     */
    private List<PlaceVO> children;

    public List<PlaceVO> getChildren() {
        return children;
    }

    public void setChildren(List<PlaceVO> children) {
        this.children = children;
    }

    public PlaceVO(Place place) {
        this.id = place.getId();
        this.dataName = place.getDataName();
        this.parentId = place.getParentId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}

class Place{
    /**
     * 数据马
     */
    private String id;
    /**
     * 名字
     */
    private String dataName;
    /**
     * 父元素的码
     */
    private String parentId;

    public Place(String id, String dataName, String parentId) {
        this.id = id;
        this.dataName = dataName;
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}

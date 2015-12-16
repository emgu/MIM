package maps;

public abstract class Map {
	static Map actualMap;
	
	abstract void createMap();
	void setActualMap(Map m){
		actualMap = m;
	};
}

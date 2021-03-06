package pl.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DataStructure {
	
	//private static Model model;
	private static List<Float> positions = new ArrayList<Float>();
//	private static Vector<Float> textures = new Vector<Float>(64000);
	private static List<Float> normals = new ArrayList<Float>();
	private static List<Face> faces = new ArrayList<Face>();
	
	private static int numberOfVertices;
	private static int numberOfNormals;
	private static int numberOfFaces;
	
	public static float [] minValues;
	public static float [] maxValues;
	
//	public static void setModel(Model model) {
//		DataStructure.model = model;
//	}
//	
//	public static Model getModel() {
//		return model;
//	}

	public static List<Float> getPositions() {
		return positions;
	}
	
	public static float [] getPositionsArray() {
		float [] array = new float[numberOfVertices];
		
		for(int i = 0; i < numberOfVertices; i++)
			array[i] = positions.get(i);
		
		return array;
	}

//	public static Vector<Float> getTextures() {
//		return textures;
//	}
//	
//	public static float [] getTexturesArray() {
//		int size = textures.size();
//		float [] array = new float[size];
//		
//		for(int i = 0; i < size; i++)
//			array[i] = textures.get(i);
//		
//		return array;
//	}

	public static List<Float> getNormals() {
		return normals;
	}
	
	public static void setNormals(float [] normals) {
		for(int i = 0; i < normals.length; i++)
			DataStructure.normals.add(normals[i]);
	}
	
	public static float [] getNormalsArray() {
		float [] array = new float[numberOfNormals];
		
		for(int i = 0; i < numberOfNormals; i++)
			array[i] = normals.get(i);
		
		return array;
	}

	public static List<Face> getFaces() {
		return faces;
	}
	
	public static short [] getIndicesArray() {
		short array [] = new short[numberOfFaces * 3];
		Vector<Short> tmp;
		int k = 0;
		short tmpValue;
		
		for(int i = 0; i < numberOfFaces * 3; i += 3) {
			tmp = faces.get(k).getvPointers();
			for(int j = 0; j < 3; j++) {
				tmpValue = tmp.get(j);
				array[i + j] = --tmpValue;			//indeskowanie w talbicy od 0 (w pliku od 1)
			}
			k++;
		}
				
		return array;
	}
	
	public static short [] getIndicesArray(int face) {
		short array [] = new short[3];
		short tmpValue;
		Vector<Short> tmp = faces.get(face).getvPointers();
		
		for(int i = 0; i < 3; i++) {
			tmpValue = tmp.get(i);
			array[i] = --tmpValue;
		}
		return array;
	}

	public static int getNumbersOfVertices() {
		return numberOfVertices;
	}

	public static void setNumbersOfVertices(int numbersOfVertices) {
		DataStructure.numberOfVertices = numbersOfVertices;
	}

	public static int getNumberOfFaces() {
		return numberOfFaces;
	}

	public static void setNumberOfFaces(int numberOfFaces) {
		DataStructure.numberOfFaces = numberOfFaces;
	}
	
	public static int getNumberOfNormals() {
		return numberOfNormals;
	}
	
	public static void setNumberOfNormals(int numberOfNormals) {
		DataStructure.numberOfNormals = numberOfNormals;
	}
	
	public static void free() {
		positions.clear();
		normals.clear();
		faces.clear();
	}
}

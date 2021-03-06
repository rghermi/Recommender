package upc.bdam.recommender.Big1DDBB.dao;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import upc.bdam.recommender.consumer.schema.SchemaAudioBean;
import upc.bdam.recommender.consumer.schema.SchemaTextBean;
import upc.bdam.recommender.consumer.schema.SchemaVideoBean;
import upc.bdam.recommender.consumer.schema.SchemaWebBean;

/**
 * 
 * @author Grupo 9: - Antol�n Barrena Rico - Carles Castillejo - Raffaele
 *         Ghermandi - David P�rez Rodr�guez
 *
 */
public class Big1DataSource {

	// declaraci�n de constantes de literales implicadas en la inserci�n.
	public static final String TEXT_ANALYTICS_TIMESTAMP_BIG2 = "big2Timestamp";
	public static final String TEXT_ANALYTICS_TIMESTAMP_ID = "id";

	private static String TEXT_ANALYTICS_TIMESTAMP = "timestamp";
	private static String TEXT_ANALYTICS_FILE_TYPE = "fileType";
	private static String TEXT_ANALYTICS_USER_ID = "userId";
	private static String TEXT_ANALYTICS_STATUS = "status";
	private static String TEXT_ANALYTICS_CONTENT = "content";
	private static String TEXT_ANALYTICS_PALABRAS = "palabras";
	private static String TEXT_ANALYTICS_URL = "url";
	private static String TEXT_ANALYTICS_METADATA = "meta";

	private static String TEXT_ANALYTICS_AUDIO_COLLECTION = "audioSchema";
	private static String TEXT_ANALYTICS_TEXT_COLLECTION = "textSchema";
	private static String TEXT_ANALYTICS_VIDEO_COLLECTION = "videoSchema";
	private static String TEXT_ANALYTICS_WEB_COLLECTION = "webSchema";



	// declarai�n de las listas de tipos de documentos
	private MongoCollection<Document> videoCollection;
	private MongoCollection<Document> audioCollection;
	private MongoCollection<Document> textCollection;
	private MongoCollection<Document> webCollection;

	// conexiones a las instancias de MongoDB
	private MongoClient client;
	private MongoDatabase big1;

	/**
	 * Constructor de clase. Se establecen las conexiones a las instancias de
	 * MongoDB
	 */
	public Big1DataSource() {
		client = new MongoClient();

		// se crea la base de datos del ejercicio y sus colecciones
		big1 = client.getDatabase("big1");

		audioCollection = big1.getCollection(TEXT_ANALYTICS_AUDIO_COLLECTION);
		textCollection = big1.getCollection(TEXT_ANALYTICS_TEXT_COLLECTION);
		videoCollection = big1.getCollection(TEXT_ANALYTICS_VIDEO_COLLECTION);
		webCollection = big1.getCollection(TEXT_ANALYTICS_WEB_COLLECTION);
	}

	/**
	 * M�todo especializado en la inserci�n de datos de audio procedentes de
	 * kafka en Big1
	 * 
	 * @param value
	 */
	public void insertAudioSchema(SchemaAudioBean value) {

		Document audio = new Document();

		audio.put(TEXT_ANALYTICS_TIMESTAMP, value.getTimestamp());
		audio.put(TEXT_ANALYTICS_FILE_TYPE, value.getFileType());
		audio.put(TEXT_ANALYTICS_USER_ID, value.getUserId());
		audio.put(TEXT_ANALYTICS_STATUS, value.getStatus());
		audio.put(TEXT_ANALYTICS_METADATA, value.getMetadata());

		audioCollection.insertOne(audio);
	}

	/**
	 * M�todo especializado en la inserci�n de datos de video procedentes de
	 * kafka en Big1
	 * 
	 * @param value
	 */
	public void insertVideoSchema(SchemaVideoBean value) {

		Document video = new Document();

		video.put(TEXT_ANALYTICS_TIMESTAMP, value.getTimestamp());
		video.put(TEXT_ANALYTICS_FILE_TYPE, value.getFileType());
		video.put(TEXT_ANALYTICS_USER_ID, value.getUserId());
		video.put(TEXT_ANALYTICS_STATUS, value.getStatus());
		video.put(TEXT_ANALYTICS_METADATA, value.getMetadata());

		videoCollection.insertOne(video);
	}

	/**
	 * M�todo especializado en la inserci�n de datos de Texto procedentes de
	 * kafka en Big1
	 * 
	 * @param value
	 */
	public void insertTextSchema(SchemaTextBean value) {

		Document text = new Document();

		text.put(TEXT_ANALYTICS_TIMESTAMP, value.getTimestamp());
		text.put(TEXT_ANALYTICS_FILE_TYPE, value.getFileType());
		text.put(TEXT_ANALYTICS_USER_ID, value.getUserId());
		text.put(TEXT_ANALYTICS_STATUS, value.getStatus());
		text.put(TEXT_ANALYTICS_CONTENT, value.getContent());
		text.put(TEXT_ANALYTICS_PALABRAS, value.getPalabras());
		text.put(TEXT_ANALYTICS_METADATA, value.getMetadata());
		textCollection.insertOne(text);
	}

	/**
	 * M�todo especializado en la inserci�n de datos web procedentes de kafka en
	 * Big1
	 * 
	 * @param value
	 */
	public void insertWebSchema(SchemaWebBean value) {

		Document web = new Document();

		web.put(TEXT_ANALYTICS_TIMESTAMP, value.getTimestamp());
		web.put(TEXT_ANALYTICS_USER_ID, value.getUserId());
		web.put(TEXT_ANALYTICS_STATUS, value.getStatus());
		web.put(TEXT_ANALYTICS_CONTENT, value.getContent());
		web.put(TEXT_ANALYTICS_URL, value.getUrl());

		webCollection.insertOne(web);
	}
}
package upc.bdam.recommender.consumer;

import upc.bdam.recommender.Big1DDBB.dao.Big1AccessManager;
import upc.bdam.recommender.graph.dao.GraphDataAccessManager;
import upc.bdam.recommender.kafka.KafkaBean;

/**
 * Clase intermediaria entre el consumer kafka y el mongo Big1
 * 
 * @author Grupo 9: 
 *           - Antol�n Barrena Rico
 *           - Carles Castillejo
 *           - Raffaele Ghermandi
 *           - David P�rez Rodr�guez
 *
 */
public class ConsumerManager {

	//�nica instancia de la clase
	private static ConsumerManager instance = null;

	/**
	 * constructor privado
	 */
	private ConsumerManager() {

	}

	public static final ConsumerManager getInstance() {
		if (instance == null) {
			instance = new ConsumerManager();
			return instance;
		} else
			return instance;
	}

	/**
	 * Transfiere los datos de los ficheros de texto
	 * @param text
	 */
	public void consume(KafkaBean bean) {
		GraphDataAccessManager.getInstance().insertUserNode(bean);
		Big1AccessManager.getInstance().consume(bean);
	}

}

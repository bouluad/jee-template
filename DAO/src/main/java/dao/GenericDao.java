package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityNotFoundException;


/**
 * @author BOULUAD
 *
 * @param <T>
 * @param <PK>
 */
public interface GenericDao<T, PK extends Serializable> {

	/**
	 * Méthode générique pour sauvgarder un objet métier
	 * 
	 * @param pObject
	 *            l'obhet à sauvgarder
	 * 
	 * @return l'objet persistant
	 */
	T create(T pObject);

	/**
	 * Méthode générique pour supprimer un objet en connaissant son identifiant
	 * 
	 * @param pId
	 *            l'identifiant (clé primaire) de l'objet à supprimer
	 */
	void delete(PK pId);

	/**
	 * Méthode générique pour mettre à jour un objet modifié en dehors de la
	 * session
	 * 
	 * @param pObject
	 *            nouvelle version de l'objet
	 */
	void update(T pObject);

	/**
	 * Méthode générique permetant de récupérer tous les objets d'un type donné
	 * 
	 * @return liste des objets
	 */
	List<T> getAll();

	/**
	 * Méthode générique permetant de récupérer tous les objets d'un type donné
	 * 
	 * @param maxResult
	 *            nombre maximal des résultats
	 * @return liste des objets
	 */

	List<T> getAll(int maxResults);

	/**
	 * Méthode générique permetant de récupérer tous les objets d'un type donné,
	 * sans avoir des doublants
	 * <p>
	 * Noter que pour cette méthode fonctionne correctement, les objets métiers
	 * doivent avoir des méthodes equalset hashCode correctement définies
	 * </p>
	 * 
	 * @return liste des objets
	 */
	List<T> getAllDistinct();

	/**
	 * Méthode générique permetant de récupérer tous les objets d'un type donné
	 * sans avoir des doublants et avec limitation du nombre des résultats
	 * <p>
	 * Noter que pour cette méthode fonctionne correctement, les objets métiers
	 * doivent avoir des méthodes equalset hashCode correctement définies
	 * </p>
	 * 
	 * @param maxResult
	 *            nombre maximal des résultats
	 * @return liste des objets
	 */
	List<T> getAllDistinct(int maxResults);

	/**
	 * Méthode générique pour obtenir un objet par son identifiant, une
	 * exception de type ObjectRetrievalFailureException sera levée si l'objet
	 * est intouvable
	 * 
	 * @param pId
	 *            l'identifiant de l'objet
	 * @return l'objet recherché
	 * @throws EntityNotFoundException
	 *             si aucun objet n'est trouvé
	 * @throws exceptions.EntityNotFoundException 
	 */
	T findById(PK pId) throws EntityNotFoundException, exceptions.EntityNotFoundException;

	/**
	 * Vérifie si un objet, de type T et identifiant pId, existe
	 * 
	 * @param pId
	 *            identifiant de l'objet
	 * @return true si un objet existe, fase sinon
	 */
	boolean exists(PK pId);

	/**
	 * retourne une entité par la valeur d'une colonne
	 * 
	 * @param pColumnName
	 *            le nom de la colonne
	 * @param pValue
	 *            la valeur de la colonne sur laquelle il faut faire la
	 *            selection
	 * @return l'entité recherchée
	 */
	List<T> getEntityByColumn(String pClassName, String pColumnName,
			String pValue);
}


package it.softre.thip.base.connettori.descrittori;

import java.sql.SQLException;

import com.thera.thermfw.common.ErrorMessage;
import com.thera.thermfw.persist.Factory;

import it.thera.thip.api.client.ApiRequest.Method;

/**
 * <h1>Softre Solutions</h1> <br>
 * 
 * @author Daniele Signoroni 16/10/2023 <br>
 *         <br>
 *         <b>71261 DSSOF3 16/10/2023</b>
 *         <p>
 *         Prima stesura.
 *         </p>
 */

public class YConnDescriptor extends YConnDescriptorPO {

	public static final String YSLS2AP1 = "YSLS2AP1";

	public static final String YSLS2AP3 = "YSLS2AP3";

	@Override
	public int save() throws SQLException {
		if (this.getFunzione().getMetodoChiamata() == Method.POST)
			this.setBusinessClass(Factory.createObject(this.getBusinessClass()).getClass().getCanonicalName()); // All'ultimo
																												// replacement
		return super.save();
	}

	public ErrorMessage checkDelete() {
		return null;
	}

	/**
	 * <h1>Controllo esistenza classe di business</h1> <br>
	 * Daniele Signoroni 14/09/2023 <br>
	 * <p>
	 * </p>
	 * 
	 * @return
	 */
	public ErrorMessage checkBusinessClass() {
		ErrorMessage em = null;
		if (this.getBusinessClass() != null) {
			try {
				Class.forName(this.getBusinessClass());
			} catch (ClassNotFoundException e) {
				em = new ErrorMessage(YSLS2AP1, this.getBusinessClass());
			}
		}
		return em;
	}

	public ErrorMessage checkBusinessClassTabella() {
		ErrorMessage em = null;
		if (this.getBusinessClassTabella() != null) {
			try {
				Class.forName(this.getBusinessClassTabella());
			} catch (ClassNotFoundException e) {
				em = new ErrorMessage(YSLS2AP1, this.getBusinessClassTabella());
			}
		}
		return em;
	}

	public ErrorMessage checkClassTransformerJSON() {
		ErrorMessage em = null;
		if (this.getClassTransformerJSON() != null) {
			try {
				Class.forName(this.getClassTransformerJSON());
			} catch (ClassNotFoundException e) {
				em = new ErrorMessage(YSLS2AP1, this.getClassTransformerJSON());
			}
		}
		return em;
	}

}

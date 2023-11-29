package it.softre.thip.base.connettori.tabelle;

import com.thera.thermfw.common.ErrorMessage;

public class YOpportunitaInserite extends YOpportunitaInseritePO {

	public ErrorMessage checkDelete() {
		return null;
	}

	@Override
	public void setHash(String rHash) {
		super.setHash(rHash);
	}

	@Override
	public String getHash() {
		return super.getHash();
	}

}

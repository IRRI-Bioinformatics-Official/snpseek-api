package org.irri.snpseek.h5;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;





public class OutputMatrix {
	// private Map<BigDecimal,String[]> mapVar2String;
	private Map mapVar2String;
	
	private static Logger log = Logger.getLogger(OutputMatrix.class.getName());

	public OutputMatrix(Map mapVar2String) {
		super();

		int pos = -1;
		this.mapVar2String = mapVar2String;
		if (mapVar2String.size() > 0) {
			if (mapVar2String.values().iterator().next() instanceof List) {
				Map mapvar2str = new LinkedHashMap();
				Iterator itVar = mapVar2String.keySet().iterator();
				while (itVar.hasNext()) {
					Object key = itVar.next();
					List<String> strlist = (List<String>) mapVar2String.get(key);
					if (pos > -1 && pos != strlist.size())
						throw new RuntimeException(
								"OutputMatrix: pos>-1 && pos!=strlist.size() " + pos + "," + strlist.size());
					pos = strlist.size();
					mapvar2str.put(key, strlist.toArray(new String[pos]));
				}
				this.mapVar2String = mapvar2str;
			}
		}
		log.info("OutputMatrix vars=" + mapVar2String.size() + " pos=" + pos);
	}

	public Map getMapVar2String() {
		return mapVar2String;
	}

	public OutputMatrix offsetVarId(int varid_offset) {
		if (varid_offset > 0) {
			// Map<BigDecimal,String[]> mapNew=new LinkedHashMap();
			Map mapNew = new LinkedHashMap();
			Iterator<BigDecimal> itVar = mapVar2String.keySet().iterator();
			while (itVar.hasNext()) {
				BigDecimal v = itVar.next();
				mapNew.put(BigDecimal.valueOf(v.longValue() + varid_offset), mapVar2String.get(v));
				log.info("offset mapVar2String varid " + v + " -> " + (v.longValue() + varid_offset));
			}
			mapVar2String = mapNew;
		}
		return this;
	}

	// Expect mapIdx2SampleId to be keyed by Integer (index) -> value is target id (e.g. BigDecimal)
	// CHANGED
	public OutputMatrix remapVarId(Map mapIdx2SampleId) {
		// Defensive: if caller passed null or an empty map, nothing to do
		if (mapIdx2SampleId == null || mapIdx2SampleId.isEmpty()) {
			log.fine("remapVarId: mapIdx2SampleId is null or empty, skipping remap");
			return this;
		}

		Map mapNew = new LinkedHashMap();
		Iterator<BigDecimal> itVar = mapVar2String.keySet().iterator();
		while (itVar.hasNext()) {
			BigDecimal v = itVar.next();
			// Expect mapIdx2SampleId to be keyed by Integer (index) -> value is target id (e.g. BigDecimal)
			Integer idxKey = Integer.valueOf(v.intValue());
			Object mapped = mapIdx2SampleId.get(idxKey);
			if (mapped == null) {
				log.warning("No sample found for var id: " + v + " (idx key: " + idxKey + ")");
				continue; // skip entries without a mapping
			}
			// Try to coerce mapped value to BigDecimal used as map key; if it's another numeric type, try to convert
			try {
				BigDecimal mappedBd = null;
				if (mapped instanceof BigDecimal) {
					mappedBd = (BigDecimal) mapped;
				} else if (mapped instanceof Number) {
					mappedBd = BigDecimal.valueOf(((Number) mapped).longValue());
				} else if (mapped instanceof String) {
					try {
						mappedBd = new BigDecimal(((String) mapped).trim());
					} catch (NumberFormatException nfe) {
						log.warning("Mapped value for idx " + idxKey + " is a string but not numeric: '" + mapped + "'");
						continue;
					}
				} else {
					log.warning("Mapped value for idx " + idxKey + " is of unsupported type: " + mapped.getClass().getName());
					continue;
				}

				mapNew.put(mappedBd, mapVar2String.get(v));
			} catch (ClassCastException cce) {
				log.warning("Failed to cast mapped value for idx " + idxKey + " to BigDecimal: " + cce.getMessage());
				// skip this mapping and continue
			}
		}
		mapVar2String = mapNew;
		return this;
	}
	/*
	 * @Override public String toString() { 
	 * StringBuffer buff= new StringBuffer(); if(listVarString!=null) { Iterator it
	 * = listVarString.iterator(); while(it.hasNext()) { buff.append( it.next()
	 * ).append("\n"); } } return buff.toString(); }
	 */

}
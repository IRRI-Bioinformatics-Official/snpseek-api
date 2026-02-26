package org.irri.snpseek.h5.object;


import java.util.List;

import org.irri.snpseek.h5.H5Dataset;
import org.irri.snpseek.h5.InputParamsIdxs;
import org.irri.snpseek.h5.OutputMatrix;

public interface H5ReadMatrix {

	public OutputMatrix read(H5Dataset hfdata, InputParamsIdxs input) throws Exception;

	public List<OutputMatrix> read(H5Dataset hfdata, List inputs);

}

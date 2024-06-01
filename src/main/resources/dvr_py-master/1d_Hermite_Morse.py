# SPDX-License-Identifier: MIT
import dvr_1d_copy
import sys
d = dvr_1d_copy.HermiteDVR(npts=int(sys.argv[1]))
d.morse_test(D=float(sys.argv[2]),a=float(sys.argv[3]),num_eigs=int(sys.argv[1]),x0=float(sys.argv[4]),precision=int(sys.argv[5]))
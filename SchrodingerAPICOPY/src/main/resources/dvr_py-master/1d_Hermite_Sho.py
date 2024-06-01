# SPDX-License-Identifier: MIT
import dvr_1d_copy
import sys
d = dvr_1d_copy.HermiteDVR(npts=int(sys.argv[1]))
d.sho_test(k=float(sys.argv[2]),num_eigs=int(sys.argv[1]),x0=float(sys.argv[3]),precision=int(sys.argv[4]))
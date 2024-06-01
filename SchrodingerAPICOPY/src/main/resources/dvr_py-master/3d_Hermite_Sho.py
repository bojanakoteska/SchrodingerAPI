# SPDX-License-Identifier: MIT
import dvr_3d_copy
import dvr_1d_copy
import sys
d1d = dvr_1d_copy.HermiteDVR(npts=int(sys.argv[1]))
d3d = dvr_3d_copy.DVR(dvr1d=d1d)
d3d.sho_test(k=float(sys.argv[2]),num_eigs=int(sys.argv[1]),x0=float(sys.argv[3]),y0=float(sys.argv[4]),z0=float(sys.argv[5]),precision=int(sys.argv[6]))
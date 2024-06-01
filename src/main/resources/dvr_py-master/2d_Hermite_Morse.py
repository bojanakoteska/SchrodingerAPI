# SPDX-License-Identifier: MIT
import dvr_2d_copy
import dvr_1d_copy
import sys
d1d = dvr_1d_copy.HermiteDVR(npts=int(sys.argv[1]))
d2d = dvr_2d_copy.DVR(dvr1d=d1d)
d2d.morse_test(D1=float(sys.argv[2]),a1=float(sys.argv[3]),D2=float(sys.argv[4]),a2=float(sys.argv[5]), num_eigs=int(sys.argv[1]),x0=float(sys.argv[6]),y0=float(sys.argv[7]), precision=int(sys.argv[8]))
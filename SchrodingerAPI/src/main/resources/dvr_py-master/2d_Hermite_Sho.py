import dvr_2d_copy
import dvr_1d_copy
import sys
d1d = dvr_1d_copy.HermiteDVR(npts=int(sys.argv[1]))
d2d = dvr_2d_copy.DVR(dvr1d=d1d)
d2d.sho_test(k=float(sys.argv[2]),num_eigs=int(sys.argv[1]),x0=float(sys.argv[3]),y0=float(sys.argv[4]),precision=int(sys.argv[5]))
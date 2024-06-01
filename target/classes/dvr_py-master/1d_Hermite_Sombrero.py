import dvr_1d_copy
import sys
d = dvr_1d_copy.HermiteDVR(npts=int(sys.argv[1]))
d.sombrero_test(a=float(sys.argv[2]),b=float(sys.argv[3]),num_eigs=int(sys.argv[1]),precision=int(sys.argv[4]))
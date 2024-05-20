import dvr_1d_copy
import sys
d = dvr_1d_copy.HermiteDVR(npts=int(sys.argv[1]))
d.woods_saxon_test(V0=float(sys.argv[2]),z=float(sys.argv[3]),r0=float(sys.argv[4]),A=int(sys.argv[5]),num_eigs=int(sys.argv[1]),precision=int(sys.argv[6]))
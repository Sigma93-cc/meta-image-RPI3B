#!/bin/sh
TARGET=$(readlink -f /dev/mainscreen) || exit 1
N=${TARGET##*/fb}
exec /usr/bin/psplash --fbdev ${N}
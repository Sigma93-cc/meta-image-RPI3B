FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://enable-display.cfg"

RRECOMMENDS:${KERNEL_PACKAGE_NAME}-base = ""
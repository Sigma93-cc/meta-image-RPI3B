FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://enablesystemd.cfg"

DEPENDS += "systemd"
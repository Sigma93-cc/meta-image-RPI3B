FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "\
    file://staticip.conf \
"

do_install:append(){
    install -d ${D}${sysconfdir}/systemd/network/80-wired.network.d/
    install -m 0644 ${WORKDIR}/staticip.conf ${D}${sysconfdir}/systemd/network/80-wired.network.d/
}

FILES:${PN} += "${sysconfdir}/systemd/network/80-wired.network.d/staticip.conf"
DESCRIPTION = "Receipt provides udev rules for device for search waveshare display"
LICENSE = "CLOSED"

SRC_URI += "file://99-waveshare.rules"

do_install(){
    install -d ${D}${sysconfdir}/udev/rules.d/
    install -m 0644 ${WORKDIR}/99-waveshare.rules ${D}${sysconfdir}/udev/rules.d/
}

FILES:${PN} = "${sysconfdir}/udev/rules.d/99-waveshare.rules"
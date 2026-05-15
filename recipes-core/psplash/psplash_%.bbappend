FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SPLASH_IMAGES:rpi = "file://studio.png;outsuffix=sigmastudio"


SRC_URI += "\
    file://framebuf.conf \
    file://psplash-mainscreen.sh \
"

do_install:append:rpi() {
    install -d ${D}${sysconfdir}/systemd/system/psplash-start.service.d/
    install -d ${D}${libexecdir}
    install -m 0644 ${WORKDIR}/framebuf.conf ${D}${sysconfdir}/systemd/system/psplash-start.service.d/
    install -m 0755 ${WORKDIR}/psplash-mainscreen.sh ${D}${libexecdir}/
}

FILES:${PN} += "\
    ${sysconfdir}/systemd/system/psplash-start.service.d/framebuf.conf \
    ${libexecdir}/psplash-mainscreen.sh \
"
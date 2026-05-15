FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SPLASH_IMAGES:rpi = "file://studio.png;outsuffix=sigmastudio"


SRC_URI += "\
    file://99-psplashscreen.conf \
    file://psplash-mainscreen.sh \
"

do_install:append:rpi() {
    rm -f ${D}${systemd_system_unitdir}/psplash-start.service.d/framebuf.conf
    install -d ${D}${libexecdir}
    install -m 0644 ${WORKDIR}/99-psplashscreen.conf ${D}${systemd_system_unitdir}/psplash-start.service.d/
    install -m 0755 ${WORKDIR}/psplash-mainscreen.sh ${D}${libexecdir}/
}

FILES:${PN} += "\
    ${systemd_system_unitdir}/psplash-start.service.d/99-psplashscreen.conf \
    ${libexecdir}/psplash-mainscreen.sh \
"